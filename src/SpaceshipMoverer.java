public class SpaceshipMoverer {

    private int xSpeed;
    private int ySpeed;
    private int speed;
    private final double dragCoefficient = .1;
//    private double turnAcceleration;
//    private double turnSpeed;
    private double angle = (Math.PI/2);
    public RectangleComponent spaceShip = new RectangleComponent(50, 50);


    public void move(){
        spaceShip.move(xSpeed, ySpeed);
//        System.out.printf("x: %d y: %d speed: %d accel: %d\n", xSpeed, ySpeed, speed, acceleration2);
        if (spaceShip.getPositionX() >= 1000){
            spaceShip.moveTo(0, spaceShip.getPositionY());
        } else if (spaceShip.getPositionY() >= 1000) {
            spaceShip.moveTo(spaceShip.getPositionX(), 0);
        } else if (spaceShip.getPositionY() < 0) {
            spaceShip.moveTo(spaceShip.getPositionX(), 975);
        }else if(spaceShip.getPositionX() < 0){
            spaceShip.moveTo(975, spaceShip.getPositionY());
        }
    }

    public void turn(){

    }


    public void accelerateY(int acceleration){
        ySpeed += acceleration;
//        System.out.println("hi");
//        desaturate(false);

    }

    public void accelerateX(int acceleration){
        xSpeed += acceleration;
//        desaturate(false);
    }

    private void desaturate(boolean decelerating){
        if (decelerating){
            xSpeed = (int) (speed * Math.cos(angle));
            ySpeed = (int) (speed * Math.sin(angle));
        }else {
            speed = (int) Math.abs(Math.sqrt((Math.pow(xSpeed, 2)
                    + Math.pow(ySpeed, 2))));
            if (xSpeed != 0 && ySpeed != 0) {
                angle = Math.atan(ySpeed / xSpeed);
            } else if (xSpeed == 0 && ySpeed > 0) {
                angle = Math.PI/2;
            } else if (xSpeed == 0 && ySpeed < 0) {
                angle = 3 * (Math.PI / 2);
            } else if (ySpeed == 0 && xSpeed > 0) {
                angle = 0;
            } else if (ySpeed == 0 && xSpeed < 0) {
                angle = Math.PI;
            }
        }
    }

    public void decelerate(){
        int dragX = (int) (xSpeed * dragCoefficient);
        int dragY = (int) (ySpeed * dragCoefficient);
        if(xSpeed != 0) {
            if (dragX == 0 && xSpeed > 0) {
                xSpeed -= 1;
            } else if (dragX == 0) {
                xSpeed += 1;
            } else{
                xSpeed -= dragX;
            }
        } if (ySpeed != 0){
            if (dragY == 0 && ySpeed > 0) {
                ySpeed -= 1;
            } else if (dragY == 0) {
                ySpeed += 1;
            } else{
                ySpeed -= dragY;
            }
        }
//        desaturate(true);
//        System.out.println("bye");
    }
}
