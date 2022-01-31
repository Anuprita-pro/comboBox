/try block for auto insert the record of product list in combobox 1
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB database = mongoClient.getDB("sofine");
            DBCollection Table;
            Table = database.getCollection("product");

            DBCursor mydoc = Table.find();

            while (mydoc.hasNext()) {
                DBObject m = mydoc.next();
                jComboBox1.addItem(new ComboItem(m.get("pname").toString(), "Value1"));
            }

        } 
        catch (Exception ex) {
        }
        //try block for auto insert the record for retrival of last value of resit
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB database = mongoClient.getDB("sofine");
            DBCollection Table;
            Table = database.getCollection("product");
                
            BasicDBObject wherequery=new BasicDBObject();
            wherequery.put("pname",jComboBox1.getSelectedItem().toString());
            BasicDBObject fields=new BasicDBObject();
            fields.put("quantity", 1);
            fields.put("pname", 1);
            fields.put("_id",0);
            DBCursor mydoc =Table.find(wherequery,fields);
            DBObject m=mydoc.next();
            jLabel19.setText(m.get("quantity").toString());
            
            }

         catch (Exception ex) {
        }
