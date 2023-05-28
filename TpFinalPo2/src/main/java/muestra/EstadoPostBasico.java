package muestra;

public class EstadoPostBasico extends EstadoDePost {

	public EstadoPostBasico(PostMuestra post) {
		super(post);
	}

	@Override
	public void opinar(Revision revision, VerificadorMuestra verificador) {
		verificador.opinarEnEstadoBasico(revision);
	}

	@Override
	protected void verificarPost() {
		// TODO Auto-generated method stub
		
	}


	
}
