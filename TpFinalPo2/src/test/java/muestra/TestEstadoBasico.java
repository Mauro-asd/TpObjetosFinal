package muestra;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;

public class TestEstadoBasico {

	Revision revisionMock;
	VerificadorMuestra verifiMock;
	EstadoPostBasico estadoTest;
	private PostMuestra post;
	
	@Before
	public void setUp() {
		revisionMock = mock(Revision.class);
		verifiMock = mock(VerificadorMuestra.class);
		post = mock(PostMuestra.class);
		
		doNothing().when(verifiMock).opinarEnEstadoExperto(revisionMock);
		
		estadoTest = new EstadoPostBasico(post);
	}
	
	@Test
	public void seInstanciaUnEstadoPostExpertoYSeRevisaSiSeColocaronTodosSusColaboradoresInternos() {
		
		PostMuestra resultadoEsperado = post;
		PostMuestra resultadoDado = estadoTest.getPost();
		
		assertEquals(resultadoDado, resultadoEsperado);
		
	}
	
	@Test
	public void seUtilizaUnEstadoPostExpertoParaOpinar() {
		estadoTest.opinar(revisionMock, verifiMock);
		
		verify(verifiMock, times(1)).opinarEnEstadoBasico(revisionMock);
	}
	
	@Test
	public void unEstadoDePostExpertoVerificaElPost() {
		
		estadoTest.verificarPost();
		
		verify(post, never()).verificarPost();
		
	}
}
