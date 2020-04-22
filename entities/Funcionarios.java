package entities;

/**
 *
 * @author alessandro
 */
public class Funcionarios {

    private Integer id;
    private String name;
    private Double salario;

    public Funcionarios(Integer id, String name, Double salario) {
        this.id = id;
        this.name = name;
        this.salario = salario;
    }

    public void salarioPlus(double x) {
        this.salario += (salario * x) / 100;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalario() {
        return salario;
    }
    

    @Override
    public String toString() {
        return "============================================"
                + "\n " + id + ", " + name
                + String.format(", R$ %.2f", salario);
    }

}
