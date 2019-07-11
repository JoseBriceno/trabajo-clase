package com.briceno;

public class cuentaLargoplazo extends Cuenta {

    public final double PENALTI= 0.05;

    public boolean retirar(double monto)
    {
        monto=monto+ (monto*PENALTI);

        return super.retirar(monto);
    }

}
