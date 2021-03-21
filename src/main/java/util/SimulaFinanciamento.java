package util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Parcela;

/**
 * @author Ruan
 */
public class SimulaFinanciamento {

    private static double TotalJur;

    public static final double VALOR_IOF = 0.0038;
    
    /**
     *
     * @param DataContratacao data em que a contratacao foi/sera feita
     * @param DiaDebito dia do mes para o debito das parcelas
     */
    public static Date calculaDataBase(Date DataContratacao, int DiaDebito) {
        Date DataBase;

        Calendar cal = Calendar.getInstance();
        cal.setTime(DataContratacao);
        int diaContratacao = cal.get(Calendar.DAY_OF_MONTH);
        int mesContratacao = cal.get(Calendar.MONTH);

        if (DiaDebito < diaContratacao) {
            cal.set(Calendar.MONTH, mesContratacao + 1);
        }
        
        cal.set(Calendar.DAY_OF_MONTH, DiaDebito);
        DataBase = cal.getTime();

        return DataBase;
    }

    public static Date dataPrimeiraParcela(Date DataContratacao, int DiaDebito) {
        Calendar calDataContratacao = Calendar.getInstance();
        calDataContratacao.setTime(DataContratacao);
        
        int mesContratacao = calDataContratacao.get(Calendar.MONTH);
        int anoContratacao = calDataContratacao.get(Calendar.YEAR);

        if (mesContratacao < 12) {
            calDataContratacao.set(Calendar.MONTH, mesContratacao++);
        }
        else {
            mesContratacao = 0;
            calDataContratacao.set(Calendar.MONTH, mesContratacao);
            calDataContratacao.set(Calendar.YEAR, anoContratacao++);
        }

        Calendar calData1Parc = Calendar.getInstance();
        calData1Parc.setTime(DataContratacao);
        calDataContratacao.set(Calendar.DAY_OF_MONTH, DiaDebito);
        Date Data1Parc = calDataContratacao.getTime();

        int dif = (int) ((Data1Parc.getTime() - DataContratacao.getTime()) / 86400000);
        if (dif < 30) {
            if (mesContratacao < 11) {
                calData1Parc.set(Calendar.DAY_OF_MONTH, DiaDebito);
                calData1Parc.set(Calendar.MONTH, mesContratacao + 1);
                calData1Parc.set(Calendar.YEAR, anoContratacao);
            }
            else {
                calData1Parc.set(Calendar.DAY_OF_MONTH, DiaDebito);
                calData1Parc.set(Calendar.MONTH, 0);
                calData1Parc.set(Calendar.YEAR, anoContratacao + 1);
            }
        }

        Data1Parc = calData1Parc.getTime();

        return Data1Parc;
    }

    public static int calculaDiasCarencia(Date DataContratacao, int DiaDebito) {
        int DiasCarencia;
        Date DataBase = calculaDataBase(DataContratacao, DiaDebito);

        DiasCarencia = (int) ((DataBase.getTime() - DataContratacao.getTime()) / 86400000);

        return DiasCarencia;
    }

    public static double calculaIOF(double ValContr) {
        return (ValContr + (ValContr * VALOR_IOF)) * VALOR_IOF;
    }

    public static double calculaJurosCarencia(double ValContr, double TaxaJuros, Date DataContratacao, int DiaDebito) {
        TaxaJuros = TaxaJuros / 100;
        double IOF = calculaIOF(ValContr);
        int DiasCarencia = calculaDiasCarencia(DataContratacao, DiaDebito);

        double JCarencia = ((ValContr + IOF) * ((Math.pow((1 + TaxaJuros), ((double) DiasCarencia / 30))) - 1));

        return JCarencia;
    }

    public static double calculaPrimeiraPrestacao(double ValContr, int NumPrest, double TaxaJuros, Date DataContratacao, int DiaDebito) {
        TaxaJuros = TaxaJuros / 100;
        Date DataBase = calculaDataBase(DataContratacao, DiaDebito);

        Calendar calDataContrat = Calendar.getInstance();
        calDataContrat.setTime(DataBase);
        Calendar calDataBase = Calendar.getInstance();
        calDataBase.setTime(DataBase);
        
        double I2 = 1 + TaxaJuros;

        int dif = (int) ((DataBase.getTime() - DataContratacao.getTime()) / 86400000);
        double N2 = (double) dif / 30;
        double N = NumPrest + N2;
        double N3 = Math.pow(I2, NumPrest) - 1;

        double N4 = N / N3;

        double ValPrest = Math.pow(I2, N4);
        double IOF = calculaIOF(ValContr);
        ValPrest = (ValContr + IOF) * (TaxaJuros * Math.pow(I2, N4));
        
        ValPrest = (ValContr + IOF) * (TaxaJuros * (Math.pow(I2, N) / N3));

        ValPrest = Math.rint(ValPrest * 100) / 100;
        return ValPrest;
    }

    public static List<Parcela> calculaTabelaPrice(double ValContr, int NumPrest, double TaxaJuros, Date DataContratacao, int DiaDebito) {
        List<Parcela> parcelas = new ArrayList<>();

        double iof = calculaIOF(ValContr);
        double JCarencia = calculaJurosCarencia(ValContr, TaxaJuros, DataContratacao, DiaDebito);
        TaxaJuros = TaxaJuros / 100;
        Date Data1Parc = dataPrimeiraParcela(DataContratacao, DiaDebito);
        double I2 = 1 + TaxaJuros;

        double SalDev = (ValContr + iof + JCarencia);

        int NumPrestI = 1;
        double CalcProxMes = SalDev * I2;

        Calendar calData1Parc = Calendar.getInstance();
        calData1Parc.setTime(Data1Parc);
        int DiaP = calData1Parc.get(Calendar.DAY_OF_MONTH);
        int MesP = calData1Parc.get(Calendar.MONTH);
        int AnoP = calData1Parc.get(Calendar.YEAR);

        double ValPrest = calculaPrimeiraPrestacao(ValContr, NumPrest, TaxaJuros * 100, DataContratacao, DiaDebito);

        double ValJuros = CalcProxMes - SalDev + JCarencia;
        double Amortizacao = ValPrest - ValJuros;
        SalDev = CalcProxMes - ValPrest;
        CalcProxMes = SalDev * I2;
        TotalJur = 0;
        
        TotalJur = TotalJur + ValJuros;

        Parcela parcela = new Parcela();
        parcela.setSequencia(NumPrestI);
        parcela.setJuros(ValJuros);
        parcela.setAmortizado(Amortizacao);
        parcela.setSaldoDevedor(SalDev);
        Calendar calP = Calendar.getInstance();
        calP.set(Calendar.DAY_OF_MONTH, DiaP);
        calP.set(Calendar.MONTH, MesP);
        calP.set(Calendar.YEAR, AnoP);
        parcela.setData(calP.getTime());
        parcelas.add(parcela);

        NumPrestI = NumPrestI + 1;
        MesP = MesP + 1;

        while (NumPrestI <= NumPrest) {

            ValJuros = CalcProxMes - SalDev;
            TotalJur = TotalJur + ValJuros;
            Amortizacao = ValPrest - ValJuros;
            SalDev = SalDev - Amortizacao;
            CalcProxMes = SalDev * I2;

            parcela = new Parcela();
            parcela.setSequencia(NumPrestI);
            parcela.setJuros(ValJuros);
            parcela.setAmortizado(Amortizacao);
            parcela.setSaldoDevedor(SalDev);
            calP.set(Calendar.DAY_OF_MONTH, DiaP);
            calP.set(Calendar.MONTH, MesP);
            calP.set(Calendar.YEAR, AnoP);
            parcela.setData(calP.getTime());
            parcelas.add(parcela);

            if (MesP < 11) {
                MesP = MesP + 1;
            } else {
                MesP = 0;
                AnoP = AnoP + 1;
            }

            NumPrestI = NumPrestI + 1;

        }

        return parcelas;
    }

    /**
     * Só pode ser usado depois do método calculaTablePrice
     * @return double
     */
    public static double getTotalJur() {
        return TotalJur;
    }

}