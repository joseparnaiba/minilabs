package Minilab2;

public class Comentario {
	 private String texto;
	    private String autor;
	    
	    public Comentario(String texto, String autor) {
	        this.texto = texto;
	        this.autor = autor;
	    }
	    
	    @Override
	    public String toString() {
	        return autor + ": " + texto;
	    }
}