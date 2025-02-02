package calculatorService;

public class NormalCalculator implements Calculator{
    public int a;
    public int b;

    public NormalCalculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double plus() {
        return a+b;
    }

    @Override
    public double minus() {
        return a-b;
    }

    @Override
    public double multiply() {
        return a*b;
    }

    @Override
    public double divide() {
        return (double) a/b;
    }
}
