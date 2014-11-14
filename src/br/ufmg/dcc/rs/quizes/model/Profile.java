package br.ufmg.dcc.rs.quizes.model;



abstract class Profile$$Base$br$ufmg$dcc$rs$quizes$model {
	protected Integer id;
	protected String name;
	
	public Profile$$Base$br$ufmg$dcc$rs$quizes$model(){
		clean();
	}
	
	protected void clean(){
		id=0;
		name = "";
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		((Profile) this).id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		((Profile) this).name = name;
	}
}

/**
 * TODO description
 */
abstract class Profile$$Money$br$ufmg$dcc$rs$quizes$model extends  Profile$$Base$br$ufmg$dcc$rs$quizes$model  {

	protected int money;
	
	protected void clean() {
		super.clean();
		money = 0;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		((Profile) this).money = money;
	}
      // inherited constructors


	
	public Profile$$Money$br$ufmg$dcc$rs$quizes$model (  ) { super(); }
	
}

/**
 * TODO description
 */
public class Profile extends  Profile$$Money$br$ufmg$dcc$rs$quizes$model  {

	protected int points;
	
	protected void clean() {
		super.clean();
		points = 0;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		((Profile) this).points = points;
	}
      // inherited constructors


	
	public Profile (  ) { super(); }

}