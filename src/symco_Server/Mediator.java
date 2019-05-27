package symco_Server;

public interface Mediator {
	public void userAdd(String data);
	public void userRemove(String data);
	public void sendMessage(String message);
}
