package DSProject;
import java.util.HashMap;
public class CityGraph
{
   HashMap<String , Node> nodes = new HashMap<>();
   HashMap<String , Edge> edges = new HashMap<>();
   HashMap<String , Person> persons = new HashMap<>();
   HashMap<String , BankAccount>  bankAccounts= new HashMap<>();
   HashMap<String , Call> calls = new HashMap<>();
   HashMap<String , Car> cars = new HashMap<>();
   HashMap<String , Home> homes = new HashMap<>();
   HashMap<String , Own> owns =new HashMap<>();
   HashMap<String , Mobile> mobiles = new HashMap<>();
   HashMap<String , Relation> relations =new HashMap<>();
   HashMap<String , Transaction> transactions =new HashMap<>();
   //-------------add nodes-------------------
   void add_nodes(Node n){
      nodes.put(n.key, n);
   }
   void add_person(Person p){
      persons.put(p.key, p);
      this.add_nodes(p);
   }
   void add_bankAccount(BankAccount ba){
      bankAccounts.put(ba.key, ba);
      this.add_nodes(ba);
   }
   void add_mobile(Mobile m){
      mobiles.put(m.key, m);
      this.add_nodes(m);
   }
   void add_car(Car c){
      cars.put(c.key, c);
      this.add_nodes(c);
   }
   void add_home(Home h){
      homes.put(h.key, h);
      this.add_nodes(h);
   }
   //-----------add edges-----------------
   void add_edge(Edge e){
      edges.put(e.key, e);
   }
   void add_call(Call c){
      calls.put(c.key, c);
      this.add_edge(c);
   }
   void add_own(Own o){
      owns.put(o.key, o);
      this.add_edge(o);
   }
   void add_relation(Relation r){
      relations.put(r.key, r);
      this.add_edge(r);
   }
   void add_transaction(Transaction t){
      transactions.put(t.key, t);
      this.add_edge(t);
   }
   //---------------get nodes------------------
   Node get_node(String k){
      return nodes.get(k);
   }
   Node get_person(String k){
      return persons.get(k);
   }
   Node get_bankAccount(String k){
      return bankAccounts.get(k);
   }
   Node get_mobile(String k){
      return mobiles.get(k);
   }
   Node add_car(String k){
      return cars.get(k);
   }
   Node add_home(String k){
      return homes.get(k);
   }
   //-----------get edges-----------------
   Edge get_edge(String k){
      return edges.get(k);
   }
   Edge get_call(String k){
      return calls.get(k);
   }
   Edge get_own(String k){
      return owns.get(k);
   }
   Edge get_relation(String k){
      return relations.get(k);
   }
   Edge get_transaction(String k){
      return transactions.get(k);
   }
}
