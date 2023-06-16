abstract class Parcela {
    public abstract double calcularArea();

    public abstract double calcularPerimetro();


}

class Circunferencia extends Parcela {
    private double radio;

    public Circunferencia(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

class Rectangulo extends Parcela {
    private double ladoSuperior;
    private double ladoInferior;
    private double altura;

    public Rectangulo(double ladoSuperior, double altura) {
        this.ladoSuperior = ladoSuperior;
        this.ladoInferior = ladoSuperior;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return ladoSuperior * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (ladoSuperior + altura);
    }


}

class Cuadrado extends Parcela {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }
}

class TrianguloRectangulo extends Parcela {
    private double ladoBase;
    private double ladoAltura;

    public TrianguloRectangulo(double ladoBase, double ladoAltura) {
        this.ladoBase = ladoBase;
        this.ladoAltura = ladoAltura;
    }

    @Override
    public double calcularArea() {
        return (ladoBase * ladoAltura) / 2;
    }

    @Override
    public double calcularPerimetro() {
        double ladoHipotenusa = Math.sqrt(ladoBase * ladoBase + ladoAltura * ladoAltura);
        return ladoBase + ladoAltura + ladoHipotenusa;
    }
}

class TrianguloEquilatero extends Parcela {
    private double lado;

    public TrianguloEquilatero(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return (Math.sqrt(3) / 4) * lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 3 * lado;
    }
}

public class Main {
    public static void main(String[] args) {

        Circunferencia circunferencia1 = new Circunferencia(2);
        Circunferencia circunferencia2 = new Circunferencia(2);
        Rectangulo rectangulo = new Rectangulo(8, 4);
        Cuadrado cuadrado = new Cuadrado(4);
        TrianguloRectangulo triangulo1 = new TrianguloRectangulo(3, 4);
        TrianguloEquilatero triangulo2 = new TrianguloEquilatero(6);


        double areaTotal = circunferencia1.calcularArea() + circunferencia2.calcularArea() + rectangulo.calcularArea()
                + cuadrado.calcularArea() + triangulo1.calcularArea() + triangulo2.calcularArea();

        double perimetroParcela = circunferencia1.calcularPerimetro() + circunferencia2.calcularPerimetro() + rectangulo.calcularPerimetro()
                + cuadrado.calcularPerimetro() + triangulo1.calcularPerimetro() + triangulo2.calcularPerimetro();


        double costoMetroCuadrado = 32;
        double costoParcela = areaTotal * costoMetroCuadrado;


        System.out.println("El área total de la parcela es " + areaTotal + " M2 ");
        System.out.println("El perímetro total de la parcela es " + perimetroParcela + " M2 ");
        System.out.println("El costo total de la parcela es " + costoParcela + " euros");


    }
}