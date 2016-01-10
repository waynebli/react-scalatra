import com.fourgee.app._
import org.scalatra._
import javax.servlet.ServletContext
import _root_.akka.actor.{ActorSystem, Props}

class ScalatraBootstrap extends LifeCycle {
  
  val system = ActorSystem()
  
  override def init(context: ServletContext) {
    context.mount(new ReactScalatraServlet(system), "/*")
  }
  
  //Make sure you shut down
  override def destroy(context:ServletContext) {
    system.shutdown
  }
}
