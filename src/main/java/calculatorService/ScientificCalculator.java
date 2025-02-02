package calculatorService;

public class ScientificCalculator extends NormalCalculator{

    public int c;

    public ScientificCalculator(int a, int b) {
        super(a, b);
    }

    public ScientificCalculator(int c) {
        super(c, 0);
        this.c = c;
    }

    public double sin(){
        return Math.sin(Math.toRadians(c));
    }

    public double cos(){
        return Math.cos(Math.toRadians(c));
    }

    public double tan(){
        return Math.tan(Math.toRadians(c));
    }

}
