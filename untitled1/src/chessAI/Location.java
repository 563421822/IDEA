package chessAI;

import java.io.Serializable;

/**
 * 棋子位置实体类
 * 坐标、玩家或者AI、位置分数
 *
 * @author Administrator
 */
public class Location implements Serializable {

    //坐标
    private final int x;
    private final int y;

    //落子所有者
    private int player;

    //分数
    private int score;

    //以下是2参、3参、4参构造方法
    public Location(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Location(int x, int y, int player) {
        super();
        this.x = x;
        this.y = y;
        this.player = player;
    }

    public int getScore() {
        return score;
    }

    //以下是setter、getter方法
    public void setScore(int score) {
        this.score = score;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPlayer() {
        return player;
    }

}