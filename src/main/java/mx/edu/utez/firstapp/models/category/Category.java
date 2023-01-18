package mx.edu.utez.firstapp.models.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.firstapp.models.subcategory.Subcategory;

import javax.persistence.*;
import java.util.List;

//propios de spring
@Entity
@Table(name = "categories")
//de terceros
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class Category {
    //indicamos que es la pj
    @Id
    //el parametro es como si fuera un autoincrement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 150)
    private String name;
    @Column(name = "status", nullable = false, columnDefinition = "tinyint default 1")
    private boolean status;
    @OneToMany(mappedBy = "category")
    //va a traer todas las categorias menos las subcategorias
    @JsonIgnore
    private List<Subcategory> subcategories;

}
