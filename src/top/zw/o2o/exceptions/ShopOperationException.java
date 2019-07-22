package top.zw.o2o.exceptions;

public class ShopOperationException extends RuntimeException {


    private static final long serialVersionUID = 858209996656431653L;

    public ShopOperationException(String msg){
        super(msg);
    }
}
