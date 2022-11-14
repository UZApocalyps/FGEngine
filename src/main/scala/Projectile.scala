import hevs.graphics.FunGraphics

import java.awt.Frame

class Projectile extends Framable {
  var damage = 1;
  var speed = 1;
  var angle = 0;

  override def accelerateWithGravity = false;

  def this(parent: FunGraphics,x: Int, y: Int, framesPath: String,name: String) {
    this()
    super.construct(parent,x,y,framesPath,name)
  }
  override def Update(): Unit ={
    super.Update
    x += speed
  }

  override def Draw(): Unit = {
    if (this.currentFrame < this.frames.length) {
      parent.drawTransformedPicture(x, y, angle, 1, this.getCurrentFrame())
    }
  }
}
