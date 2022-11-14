//import hevs.graphics.FunGraphics
//import hevs.graphics.advanced.Drawable
//
//trait Drawable{
//  def draw(f : FunGraphics)
//}
//
//trait Simulatable{
//  def step()
//}
//
//class Ship extends Simulatable with Drawable{
//  override def step(): Unit = ???
//  override def draw(f: FunGraphics): Unit = ???
//}
//
//class Laser extends Simulatable with Drawable{
//  override def step(): Unit = ???
//  override def draw(f: FunGraphics): Unit = ???
//}
//
//class Check {
//
//  var units = List(new Ship, new Ship)
//
//  while(true){
//    for(u <- units){
//      u.step()
//      u.Draw()
//    }
//  }
//
//}
