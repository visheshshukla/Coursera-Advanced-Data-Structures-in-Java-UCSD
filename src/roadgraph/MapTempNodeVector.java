package roadgraph;

public class MapTempNodeVector implements Comparable<MapTempNodeVector> {
	private MapNode startNode;
	private MapNode endNode;
	private double actualDistance;
	private double totalDist;
	private double lineDistance;
	
	public MapTempNodeVector(MapNode start, MapNode end){
		this.startNode = start;
		this.endNode = end;
		this.actualDistance = Double.POSITIVE_INFINITY; 
		this.totalDist = Double.POSITIVE_INFINITY; 
		this.lineDistance=0;
	}
	
	public void setEstimatedDistance(MapNode start, MapNode goal){
		
		this.lineDistance  = start.getLocation().distance(goal.getLocation());
		updateTotalDistance();
		
	}
	
	private void updateTotalDistance(){
		
		this.totalDist = this.lineDistance+this.actualDistance;
		
	}
	
	public void setActualDistance(double distance){
		
		this.actualDistance = distance;
		
	}
	
	public void initializeActualDistance(){
		
		this.actualDistance = 0;
		
	}
	
	public void initializePredictedDistance(){
		this.lineDistance=0;
	}
	
	public MapNode getEndNode(){
		
		return this.endNode;
		
	}
	
	public double getTotalDist(){
		
		return this.totalDist;
		
	}
	
	public double getActualDist(){
		
		return this.actualDistance;
		
	}
	
	public MapNode getStartNode(){
		
		return this.startNode;
		
	}
	
	public int compareTo(MapTempNodeVector node){
		
		if(this.totalDist<node.totalDist){
			return -1;
		} else if(this.totalDist>node.totalDist){
			return 1;
		}
		return 0;
		
	}
}