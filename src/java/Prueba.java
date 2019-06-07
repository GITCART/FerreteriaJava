
import dao.CategoriaDao;
import java.util.ArrayList;
import transferObject.Categoria;



/**
 *
 * @author Computer
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CategoriaDao catedao= new CategoriaDao();
        
        //ArrayList<Categoria> lista= new ArrayList<>();
        
       Categoria cate = new Categoria();
        cate.setIdCategoria(1);
        cate.setDescripcion("metales");
        cate.setEstado('B');
        //catedao.insertarCategoria(cate);
        
        catedao.actualizarCategoria(cate);
        //lista = catedao.listarCategoria();
        
        //para acceder al 
       /*for (int i = 0; i < lista.size(); i++) {
            System.out.println("dato:"+lista.get(i).getDescripcion()); // mmuestra un objeto
        }*/
        
        //eliminar
        //catedao.eliminarCategoria(1);
    }
    
}
