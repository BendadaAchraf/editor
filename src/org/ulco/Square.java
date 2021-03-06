package org.ulco;

public  class Square extends GraphicsObject {
    public Square(Point center, double length) {
        this.m_origin = center;
        this.m_length = length;
    }




    public    Point getM_origin()
    {

        return m_origin;
    }

    public    Double getlegnth()
    {
        return m_length;
    }

    public void CreatBytype(String json) {
        String str = json.replaceAll("\\s+","");
        int centerIndex = str.indexOf("center");
        int lengthIndex = str.indexOf("length");
        int endIndex = str.lastIndexOf("}");

        m_origin = new Point(str.substring(centerIndex + 7, lengthIndex - 1));
        m_length = Double.parseDouble(str.substring(lengthIndex + 7, endIndex));
    }

    @Override
    public void CreatebyCouleur(Couleur C) {
        this.couleur=C;
    }

    public GraphicsObject copy() {
        return new Square(m_origin.copy(), m_length);
    }

    public Point getOrigin() { return m_origin; }



   public  boolean isClosed(Point pt, double distance){

       Point center = new Point(m_origin.getX() + m_length / 2, m_origin.getY() + m_length / 2);
       //Point center = new Point(m_origin.getX() + m_width / 2, m_origin.getY() + m_height / 2);



       return Math.sqrt((center.getX() - pt.getX()) * (center.getX() - pt.getX()) +
               ((center.getY() - pt.getY()) * (center.getY() - pt.getY()))) <= distance;

   }






    void move(Point delta) { m_origin.move(delta); }

    public String toJson() {
        return "{ type: square, center: " + m_origin.toJson() + ", length: " + this.m_length + " }";
    }

    public Square()
    {


    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public String toString() {
        return "square[" + m_origin.toString() + "," + m_length + "]";
    }

    private      Point m_origin;
    private      double m_length;
    private      Couleur couleur;
}
