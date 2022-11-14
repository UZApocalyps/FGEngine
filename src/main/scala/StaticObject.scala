import hevs.graphics.FunGraphics
import hevs.graphics.utils.GraphicsBitmap

class StaticObject extends GameObject {

  private var frame : String = null
  private var image : GraphicsBitmap = null
  override def accelerateWithGravity() = false

  def this(window: FunGraphics,x:Int,y:Int, frame:String){
    this()
    this.parent = window
    this.frame = frame
    image = new GraphicsBitmap(frame)
    this.x = x
    this.y = y

  }

  /**
   * Define if the object can be ticked by game manager
   */
  override def Tickable: Boolean = false

  /**
   * Method called by game manager to update the object.
   */
  override def Update: Unit = {

  }

  /**
   * Boolean to detect if object is moving
   */
  override var isMoving: Boolean = _

  /**
   * Draw object on screen
   */
  override def Draw(): Unit = {
    parent.drawTransformedPicture(x, y, 0, 1, image)
  }
}
