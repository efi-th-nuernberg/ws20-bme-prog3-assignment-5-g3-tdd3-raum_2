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
    // TODO Auto-generated method stub
    return null;
  }
}