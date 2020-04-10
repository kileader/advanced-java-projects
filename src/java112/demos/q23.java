Map<String, String> map;
map = new HashMap<String, String>();

map.put("WI", "Wisconsin");
map.put("NY", "New York");
map.put("AZ", "Arizona");

if (map.containsKey("WI")) {
    System.out.println(map.get("WI"));
} else {
    System.out.println("ERROR: Value not in map");
}
