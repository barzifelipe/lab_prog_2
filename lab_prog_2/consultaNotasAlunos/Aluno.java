package consultaNotasAlunos;

public class Aluno {
	
	private int matricula;
	private String nomeAluno;
	private double nota1;
	private double nota2;
	
		
	
	public Aluno(int matricula, String nomeAluno, double nota1, double nota2) {
		
		this.matricula = matricula;
		this.nomeAluno = nomeAluno;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}

	public Aluno(){
		
		this.matricula = 0;
		this.nomeAluno = "";
		this.nota1 = 0;
		this.nota2 = 0;
		
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	
	


}
