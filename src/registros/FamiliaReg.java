package registros;

/**
 *
 * @author fermani
 */
public class FamiliaReg implements Item {
    
    private int id;
    private int padre_id;
    private int nivel;
    private String descripcion;

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public int getIdPadre() {
        return padre_id;
    }
    
    public void setIdPadre(int padre_id) {
        this.padre_id = padre_id;
    }
}
