import java.awt.Rectangle
import scala.reflect.ClassManifestFactory.Any
import scala.collection._
import scala.collection.mutable.ListBuffer

class Collider extends collisionable {

  private var child: GameObject = null

  //use to register event that will be triggered when this object collide with another
  var collided : ListBuffer[(CollideEvent)=>Unit] = ListBuffer()

  def this(child: GameObject) {
    this()
    this.child = child
    bounds = child.bounds

  }

  override def collided(event: CollideEvent): Unit = {
    //check type of collided object
    collided.foreach(c=>{
      c(event)
    });
  }

  override def checkCollision(gameObject1: GameObject, gameObject2: GameObject): Unit = {

    //check if gameObject1 is in bounds of gameObject2
    if (gameObject1.bounds.intersects(gameObject2.bounds)) {
      collided(new CollideEvent(gameObject1, gameObject2))
    }


  }

  override def Update: Unit =
    {
      this.bounds.x = child.x-bounds.width/2
      this.bounds.y = child.y-bounds.height/2
      child.bounds = this.bounds
      if (drawHitBox) {
        //draw bounds
        child.parent.drawRect(bounds.x, bounds.y , bounds.width, bounds.height)
      }
    }
}


trait collisionable {
  //bounds of the object
  var bounds: Rectangle = null
  def collided(event: CollideEvent): Unit;
  def checkCollision(gameObject1: GameObject,gameObject2: GameObject);
  def Update : Unit
  var drawHitBox = false
}
class CollideEvent {
  def this(gameObject1: GameObject, gameObject2: GameObject) {
    this()
    this.obj_collided = gameObject1
    this.obj_collided_with = gameObject2
  }
  var obj_collided: GameObject = null
  var obj_collided_with: GameObject = null
}

