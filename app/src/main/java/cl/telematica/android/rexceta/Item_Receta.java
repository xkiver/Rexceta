package cl.telematica.android.rexceta;

import java.util.List;

/**
 * Created by Jesi on 05-10-16.
 */
public class Item_Receta {

    private String nombre;
    private String descripcion;
    private int valoracion; //si me funciona como string busco como dejarlo como fecha
    private String video;
    private String imagen;
    private String dificultad;
    private String json;
    private String tiempo;
    private List<String> ingredientes;
    private String categoria;
    private List<String> etiquetas;
    private String preparacion;
    private String autor;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> nombre) {
        this.ingredientes = ingredientes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getValoracion(){
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getVideo(){
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImagen(){
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDificultad(){
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getlinkJS(){
        return json;
    }

    public void setLinkJS(String json) {
        this.json = json;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String getPreparacion(){
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
