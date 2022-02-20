
public class Calc implements IPosfixCalc{

    StackArrayList<Integer> lista = new StackArrayList<Integer>();

    int respuesta;
    int valorA;
    int valorB;

    String actual;

    boolean valores;
    boolean operadores;

    String[] values = {"1","2","3","4","5","6","7","8","9"};
    String[] operators = {"*", "/", "+", "-"};

    public Calc() {
        respuesta = 0;
        valorA = 0;
        valorB = 0;
    
        actual = "";
    
        valores = false;
        operadores = false;
    
    }


    @Override
    public int Evaluate(String expresion) {
        String[] exp = expresion.split(" ");

        for (int i = 0; i <= exp.length - 1; i++) {
            respuesta = 0;
            actual = exp[i];
            for(int e = 0; e >= 9; e++){
                if(actual == values[e]){
                    valores = true;
                }
                if(actual == operators[e]){
                    operadores = true;
                }
            }

            if(valores || operadores){
                if (valores) {
                    lista.push(Integer.parseInt(actual));
                }
                if (operadores) {
                    valorA = 0;
                    valorB = 0;

                    try {
                        valorA = lista.peek();
                        lista.pull();
                        valorB = lista.peek();
                        lista.pull();
                    } catch (Exception e) {

                        while (!lista.isEmpty()) {
                            lista.pull();
                        }

                        return 2;

                    }

                    switch(actual){
                        case "+":
                            lista.push(valorA + valorB);
                            break;

                        case "-":
                            lista.push(valorA - valorB);
                            break;

                        case "/":

                            if (valorB == 0) {
                                while (!lista.isEmpty()) {
                                    lista.pull();
                                }
                                return 3;

                            } else if (valorB > valorA) {
                                while (!lista.isEmpty()) {
                                    lista.pull();
                                }
                                return 4;

                            } else {
                                lista.push(valorA / valorB);
                            }
                            break;

                        case "*":
                            lista.push(valorA * valorB);
                            break;
                    }



                    }


                }
            }
        respuesta = lista.peek();
        while (!lista.isEmpty()) {
            lista.pull();
        }
        return respuesta;
    
    }
    
}