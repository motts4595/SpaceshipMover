public class SpaceshipMoverer {

    private int xSpeed;
    private int ySpeed;
    private double inertia = .1; // between zero and one, higher is quicker slow down
    private int acceleration;
    private int fuelCap;
    private int currentFuel = fuelCap;
    private int fuelEfficiency;
    private int count;
//    private double turnAcceleration;
//    private double turnSpeed;
    private double angle = (Math.PI/2);
    public RectangleComponent spaceShip = new RectangleComponent(50, 50);


    public SpaceshipMoverer(){
        //TODO set fuel stuff, acceleration, and inertia
    }
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
        updateFuel();
    }



    public void updateFuel(){
        if (count >= fuelEfficiency){
            count = 0;
            currentFuel--;
        }else {
            count ++;
        }
    }

    public void acceleratePosY(){
        ySpeed += acceleration;

    }
    public void accelerateNegY(){
        ySpeed += acceleration;

    }    public void accelerateNegX(){
        ySpeed += acceleration;

    }

    public void acceleratePosX(){
        xSpeed += acceleration;
    }


    public void decelerate(){
        int dragX = (int) (xSpeed * inertia);
        int dragY = (int) (ySpeed * inertia);
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
