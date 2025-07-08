package ShipmentService;

import java.util.ArrayList;

public class PendingShipments {
    private ArrayList<Shipment> shipments;
    private int shipmentCount;
    public PendingShipments(){
        shipments = new ArrayList<Shipment>();
        shipmentCount=0;
    }
    public ArrayList<Shipment> getBooks() {
        return shipments;
    }
    public void addShipment(Shipment shipment) {
        shipments.add(shipment);
        shipmentCount++;
    }
    public void removeShipment(Shipment shipment) {
        shipments.remove(shipment);
    }
}
