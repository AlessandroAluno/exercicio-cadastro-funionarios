package application;

import entities.Funcionarios;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author alessandro
 */
public class ProgramaLista {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Funcionarios> fun = new ArrayList<>();

        System.out.print("Digite o número de funcionarios: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Nome: ");
            String name = sc.nextLine();

            System.out.print("Salário: ");
            double salario = sc.nextDouble();
            System.out.println("");

            //O bloco a baixo é a verificação de id duplicado
            if (i != 0) {
                Integer f = id;
                Funcionarios result = fun.stream().filter(x -> x.getId() == f)
                        .findFirst().orElse(null);
                if (result != null) {
                    System.out.println("Id já cadastrado!\n");

                    System.out.print("Id: ");
                    id = sc.nextInt();

                    System.out.print("Nome: ");
                    sc.nextLine();
                    name = sc.nextLine();

                    System.out.print("Salário: ");
                    salario = sc.nextDouble();

                    fun.add(new Funcionarios(id, name, salario));
                }
            }
            fun.add(new Funcionarios(id, name, salario));

        }

        System.out.print("\nInforme o código do funcionário: ");
        int nf = sc.nextInt();

        Funcionarios result = fun.stream().filter(x -> x.getId() == nf)
                .findFirst().orElse(null); //continuação do codigo de cima

        if (result == null) {
            System.out.print("Funcionário não existe!\n");
            System.out.println("");
        } else {
            System.out.print("Digite a porcentagem do aumento: ");
            result.salarioPlus(sc.nextDouble());
        }
        System.out.println("");
        for (int g = 0; g < n; g++) {
            System.out.println(fun.get(g));
        }

        sc.close();
        
    }

}
