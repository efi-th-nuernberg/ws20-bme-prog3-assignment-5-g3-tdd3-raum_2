public class Life implements ILife {
  
  //public boolean[][] habitat;
  public char[][] habitat = new char[5][5];

  public static void main(String[] args) {
    Life l = new Life(new String[] {  "     ",
                                      "     ",
                                      " *** ",
                                      "     ",
                                      "     " });
    l = (Life) l.nextGeneration();
  }

  public Life() {
    nukeAll();
    
  }

  public Life(String[] setup) {
    this();
    for (int y = 0; y < setup.length; y++)
      for (int x = 0; x < setup[y].length(); x++)
        if (setup[y].charAt(x) != ' ')
          setAlive(x, y);
        else setDead(x,y);
  }


  @Override
  public void nukeAll() {
    for(int y = 0; y < habitat.length; y++)
      for(int x = 0; x < habitat[0].length; x++)
        setDead(x,y);
  }

  @Override
  public void setAlive(int x, int y) {
    habitat[x][y] = '*';
  }

  @Override
  public void setDead(int x, int y) {
    habitat[x][y] = ' ';
  }

  @Override
  public boolean isAlive(int x, int y) {
    if(habitat[x][y] == '*') return true;
    else return false;
  }

  @Override
  public ILife nextGeneration() {
    Life nextGen = new Life();

    //nextGen.setAlive(1,1);
    // TODO Auto-generated method stub

    for(int y = 0; y < habitat.length; y++){
      for(int x = 0; x < habitat[0].length; x++){
        if(!this.isAlive(x, y) && numberOfNeighbors(x,y) == 3) nextGen.setAlive(x, y);
        //else if(this.isAlive(x, y) && 2 <= numberOfNeighbors(x,y) <= 3) nextGen.setAlive(x, y);
        else nextGen.setDead(x,y);
      }
    }
    return(nextGen);
  }

  public int numberOfNeighbors(int x, int y){
    int neighbors =0;
    for(int i = y-1; i <= y+1; i++){
      if(i<0 || i >= habitat.length) break;
      for(int j = x-1; j<= x+1; j++){
        if(j<0 || j >= habitat[0].length) break;
        if(habitat[j][i]=='*') neighbors++;
      }
    }
    if(habitat[x][y]=='*') neighbors--;
    return(neighbors);
  }
}