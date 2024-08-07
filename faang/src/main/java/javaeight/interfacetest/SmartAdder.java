package javaeight.interfacetest;

@FunctionalInterface
public interface SmartAdder extends Adder{

    //int add(int a, int b);
    double add(double a, double b);

    default int add(int a, int b){
        //return (int) add((double)a, (double) b);
        return 0;
    }
}
