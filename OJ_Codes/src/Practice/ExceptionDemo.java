package Practice;

class ExceptionDemo{
    public static void main(String[] args){ //throws ArrayIndexOutOfBoundsException
        int[] arr = new int[3];
        try	{
            System.out.println( arr[5] );// 会抛出ArrayIndexOutOfBoundsException当产生异常时，必须有处理方式。要么捕获，要么声明。
        }
        catch (ArrayIndexOutOfBoundsException e) { //括号中需要定义什么呢？try中抛出的是什么异常，在括号中就定义什么异常类型。
            System.out.println("异常发生了");
        } finally {
            arr = null; //把数组指向null，通过垃圾回收器，进行内存垃圾的清除
        }
        System.out.println("程序运行结果");
    }
}
