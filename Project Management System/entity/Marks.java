package entity;

import java.lang.*;

public class Marks
{
	private String stid;
	private double oopp, pa, eh, dd, fn, pr, to;
	
	public Marks(){}
	public Marks(String stid, double oopp, double pa, double eh, double dd, double fn, double pr, double to)
	{
		this.stid = stid;
		this.oopp = oopp;
		this.pa = pa;
		this.eh = eh;
		this.fn = fn;
		this.pr = pr;
		this.dd = dd;
		this.to = to;
	}
	public void setstid(String stid){
		this.stid = stid;
	}
	public void setoopp(double oopp){
		this.oopp = oopp;
	}
	public void setpa(double pa){
		this.pa = pa;
	}
	public void seteh(double eh){
		this.eh = eh;
	}
	public void setfn(double fn){
		this.fn = fn;
	}
	public void setpr(double pr){
		this.pr = pr;
	}
	public void setto(double to){
		this.to = to;
	}
	public void setdd(double dd)
	{
		this.dd = dd;
	}
	
	public String getstid()
	{
		return stid;
	}
	public double getoopp()
	{
		return oopp;
	}
	public double getpa()
	{
		return pa;
	}
	public double geteh()
	{
		return eh;
	}
	public double getdd()
	{
		return dd;
	}
	public double getfn()
	{
		return fn;
	}
	public double getpr()
	{
		return pr;
	}
	public double getto()
	{
		return to;
	}
}