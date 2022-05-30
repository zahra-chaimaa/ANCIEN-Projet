package jcolibri.test.test1;

import jcolibri.cbrcore.Attribute;

public class CasenosoSolution implements jcolibri.cbrcore.CaseComponent{

//string id
	int id;
	int p;
	int u;
	int b;
	int skt;
	int autr;
	int pas;
	int conf;
	
	
	public String toString()
	{
		return "("+id+";"+nip+";"+p+";"+u+";"+b+";"+skt+";"+autr+";"+pas+";"+conf+")";
	}
	
	
public Attribute getIdAttribute() {
		
		return new Attribute("id", this.getClass());
	}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


String nip;
public String getNip() {
	return nip;
}


public void setNip(String nip) {
	this.nip = nip;
}

	



	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}



	public int getU() {
		return u;
	}
	public void setU(int u) {
		this.u = u;
	}



	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}



	public int getSkt() {
		return skt;
	}
	public void setSkt(int skt) {
		this.skt = skt;
	}






	public int getAutr() {
		return autr;
	}
	public void setAutr(int autr) {
		this.autr = autr;
	}






	public int getPas() {
		return pas;
	}
	public void setPas(int pas) {
		this.pas = pas;
	}






	public int getConf() {
		return conf;
	}
	public void setConf(int conf) {
		this.conf = conf;
	}






	public static void main(String[] args) {
		CasenosoSolution f = new CasenosoSolution() ;	
	}


}


