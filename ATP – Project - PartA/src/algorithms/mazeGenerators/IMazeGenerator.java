package algorithms.mazeGenerators;

public interface IMazeGenerator {

    public Maze generate(int rows, int col);//todo -names
    public long measureAlgorithmTimeMillis(int rows, int col);
}
