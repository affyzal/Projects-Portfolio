
import java.util.*;
import java.time.*;

public class AppointmentTree {
  private TreeMap<LocalDate, LinkedList<Appointment>> tree;

  /**
  * Returns value of tree
  * @return tree
  */
  public TreeMap<LocalDate, LinkedList<Appointment>> getTree() {
    return tree;
  }

  /**
  * Sets new value of tree
  * @param TreeMap< LocalDate , LinkedList<Appointment>> tree
  */
  public void setTree(TreeMap<LocalDate, LinkedList<Appointment>> tree) {
    this.tree = tree;
  }

  /**
  * Default empty AppointmentTree constructor
  */
  public AppointmentTree() {
    super();
    this.tree = new TreeMap<LocalDate, LinkedList<Appointment>>();
  }

  /**
  * Default AppointmentTree constructor
  */
  public AppointmentTree(TreeMap<LocalDate, LinkedList<Appointment>> tree) {
    super();
    this.tree = tree;
  }

  
  /**
   * add appointment to tree
   * @param Appointment appointment
   */
  public void add(Appointment appointment) throws AddAppointmentException {
    LocalDate aptDate = appointment.getStart().toLocalDate();
       if(tree.get(aptDate)==null){
           tree.put(aptDate, new LinkedList<Appointment>());
           tree.get(aptDate).add(appointment);
       }
       else{
           LinkedList<Appointment> treeNode = tree.get(aptDate);
           Iterator<Appointment> listIter = treeNode.iterator();
           int i = 0;
           boolean found = false;
           while(listIter.hasNext()&&!found){
               Appointment current = listIter.next();
               if(current.getStart() == appointment.getStart()){
                   AddAppointmentException e = new AddAppointmentException();
                   e.setAppointment(appointment);
                   throw e;
               }
               else if(current.getStart().isBefore(appointment.getEnd())){
                   found = true;
               }
               else{
                   i++;
               }
           }
           treeNode.add(i,appointment);
       }
  }

  /**
   * delete appointment 
   * @param Appointment appointment
   */
  public void delete(Appointment appointment) throws AppointmentNotFoundException {
    LocalDate aptDate = appointment.getStart().toLocalDate();
    LinkedList<Appointment> treeNode = tree.get(aptDate);
    if (treeNode == null) {
      throw new AppointmentNotFoundException(appointment);
    } else if (treeNode.size() == 0) {
      tree.remove(aptDate);
      throw new AppointmentNotFoundException(appointment);
    } else {
      if (treeNode.remove(appointment)) {
        if (treeNode.size() == 0) {
          tree.remove(aptDate);
        }
      } else {
        throw new AppointmentNotFoundException(appointment);
      }
    }
  }

  /**
   * find appointment by time
   * @param LocalDateTime dateTime
   * @return temp
   */
  public Appointment find(LocalDateTime dateTime) throws AppointmentNotFoundException {
    LocalDate aptDate = dateTime.toLocalDate();
    LinkedList<Appointment> treeNode = tree.get(aptDate);
    if(treeNode!=null){
      Iterator<Appointment> iter = treeNode.iterator();
      while (iter.hasNext()) {
        Appointment temp = iter.next();
        if (temp.getStart().equals(dateTime)) {
          return temp;
        }
      }
    }

    throw new AppointmentNotFoundException();
  }

  
  /**
   * find appointment by date
   * @param LocalDate date
   * @return temp
   * 
   */
  public LinkedList<Appointment> find(LocalDate date) throws AppointmentNotFoundException {
    LinkedList<Appointment> temp;
    try {
      temp = tree.get(date);
    } catch (NullPointerException e) {
      throw new AppointmentNotFoundException();
    }

    return temp;
  }

  /**
   * return all appointments
   * @return appointments
   */
  public LinkedList<Appointment> allAppointments(){
    LinkedList<Appointment> appointments = new LinkedList<Appointment>();
    NavigableSet<LocalDate> keySet = tree.navigableKeySet();
    Iterator<LocalDate> iter = keySet.iterator();
    while(iter.hasNext()){
      appointments.addAll(tree.get(iter.next()));
    }
    return appointments;
  }
}
