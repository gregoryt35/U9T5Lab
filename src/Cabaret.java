import java.util.ArrayList;

public class Cabaret {
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name) {
        this.name = name;
        performers = new ArrayList<Performer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Performer> getPerformers() {
        return performers;
    }

    public boolean addPerformer(Performer performer) {
        if (performers.indexOf(performer) == -1) {
            performers.add(performer);
            return true;
        }
        return false;
    }

    public boolean removePerformer(Performer performer) {
        if (performers.indexOf(performer) != -1) {
            performers.remove(performer);
            return true;
        }
        return false;
    }

    public double averagePerformerAge() {
        double sum = 0;
        for (Performer performer : performers) {
            sum += performer.getAge();
        }
        return sum / performers.size();
    }

    public ArrayList<Performer> performersOverAge(int age) {
        ArrayList<Performer> performersOverAge = new ArrayList<Performer>();
        for (Performer performer : performers) {
            if (performer.getAge() >= age) {
                performersOverAge.add(performer);
            }
        }
        return performersOverAge;
    }

    public void groupRehearsal() {
        for (Performer performer : performers) {
            if (performer instanceof Comedian) {
                Comedian temp = (Comedian) performer;
                System.out.println("REHEARSAL CALL! " + temp.getName());
                temp.rehearse(false);
            }
            else {
                System.out.println("REHEARSAL CALL! " + performer.getName());
                performer.rehearse();
            }
        }
    }

    public void cabaretShow() {
        for (Performer performer : performers) {
            System.out.println("Welcome to the cabaret! Next act up... " + performer.getName());
            if (performer instanceof Dancer) {
                Dancer temp = (Dancer) performer;
                temp.pirouette(2);
                temp.perform();
            }
            else {
                performer.perform();
            }
        }
    }

}