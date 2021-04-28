package ar.edu.unju.fi.tp3.model;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Cliente {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;
	
	//Calendar
	//private Date fechaUltimCompra = new Date();
	
	private int nroDoc;
	private String tipoDoc;
	private int codigoAreaTel;
	private int numTel;
	private String email;
	private String nombreApellido;
	private String password;
	
	public Cliente() {
	// TODO Auto-generated constructor stub
	}

	public int getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(int nroDoc) {
		this.nroDoc = nroDoc;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public int getCodigoAreaTel() {
		return codigoAreaTel;
	}

	public void setCodigoAreaTelo(int codigoAreaTel) {
	this.codigoAreaTel = codigoAreaTel;
	}

	public int getNumTel() {
		return numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoAreaTel;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + nroDoc;
		result = prime * result + numTel;
		result = prime * result + ((tipoDoc == null) ? 0 : tipoDoc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (codigoAreaTel != other.codigoAreaTel)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (nroDoc != other.nroDoc)
			return false;
		if (numTel != other.numTel)
			return false;
		if (tipoDoc == null) {
			if (other.tipoDoc != null)
				return false;
		} else if (!tipoDoc.equals(other.tipoDoc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [nroDoc=" + nroDoc + ", fechaNacimiento=" + fechaNacimiento + ", tipoDoc="
				+ tipoDoc + ", codigoAreaTel=" + codigoAreaTel + ", numTel=" + numTel
				+ ", email=" + email + "]";
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEdad() {
		int edad = 0;
		LocalDate fechahoy = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, fechahoy);
		edad = periodo.getYears();		
		return edad;

	}

	public String getTiempoDesdeUltimaCompra() {
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaUltimaCompra, fechaActual);
		return " Tiempo desde la última compra: " + " Año: " + periodo.getYears() + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays() ;
	
}

	public String getTiempoProxCumple() {
		LocalDate hoy= LocalDate.now();
		LocalDate fechaCumpleaños= getFechaNacimiento();

  	 LocalDate proxCumpleaños = fechaCumpleaños.withYear(hoy.getYear());

  	 if (proxCumpleaños.isBefore(hoy) || proxCumpleaños.isEqual(hoy)) {
  		 proxCumpleaños = proxCumpleaños.plusYears(1);
  	 }

  	 Period periodo = Period.between(hoy, proxCumpleaños);
  	 return "Tiempo hasta el proximo cumpleaños: " + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays();
	}


	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}


	}