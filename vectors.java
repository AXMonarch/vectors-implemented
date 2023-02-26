public class Vector3D {

    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z)
    {
    this.x = x;
    this.y = y;
    this.z = z;
    }

    public double getR()
    {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public double getTheta()
    {
        return Math.acos(z/getR());
    }

    public double getPhi()
    {
        return Math.atan(y/x);
    }

    public static Vector3D add(Vector3D lhs, Vector3D rhs)
    {
        return new Vector3D((lhs.x + rhs.x),(lhs.y + rhs.y),(lhs.z + rhs.z));
    }

    public static Vector3D scale(Vector3D v, double scalefactor)
    {
        return new Vector3D((scalefactor*(v.x)),(scalefactor*(v.y)),(scalefactor*(v.z)));
    }

    public static double dotproduct(Vector3D lhs, Vector3D rhs)
    {
        return (lhs.x * rhs.x) + (lhs.y * rhs.y) + (lhs.z * rhs.z);
    }

    public static Vector3D directionvector(Vector3D v)
    {
        return new Vector3D((v.x/v.getR()),(v.y/v.getR()),(v.z/v.getR()));
    }

    public static Vector3D projection(Vector3D v1, Vector3D v2)
    {
        double dp = dotproduct(v1,v2);
        double R = v2.getR();
        return scale(v2, dp/(R*R));

    }

    public static Vector3D crossproduct(Vector3D lhs, Vector3D rhs)
    {
        return new Vector3D(lhs.y*rhs.z - lhs.z*rhs.y, lhs.z*rhs.x - lhs.x*rhs.z, lhs.x*rhs.y - lhs.y*rhs.x);
    }

    public static double tripleScalar(Vector3D v1, Vector3D v2, Vector3D v3)
    {
        return dotproduct(v1, crossproduct(v2, v3));
    }

    public static Vector3D tripleVector(Vector3D v1, Vector3D v2, Vector3D v3)
    {
        return (crossproduct(v1 ,crossproduct(v2, v3)));
    }

    public static boolean Independence(Vector3D v1, Vector3D v2)
    {
        if (dotproduct(v1, v2) == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {

        Vector3D vect = new Vector3D(1,2,3);
        Vector3D vect2 = new Vector3D(3.5,4.5,5.5);

        Vector3D addObject = add(vect,vect2);
        double dotObject = dotproduct(vect,vect2);
        Vector3D scaleObject = scale(vect, 2);
        Vector3D unitVector = directionvector(vect);
        Vector3D projectObject = projection(vect, vect2);
        Vector3D crossObject = crossproduct(vect, vect2);
        boolean linear_ind_obj = Independence(vect, vect2);


        System.out.println(addObject.x+" "+addObject.y+" "+addObject.z); // addition
        System.out.println(dotObject); // dot product
        System.out.println(scaleObject.x+" "+ scaleObject.y+" "+scaleObject.z); // Scale Factor
        System.out.println(unitVector.x+" "+ unitVector.y+" "+unitVector.z); // Unit vectors
        System.out.println(projectObject.x+" "+ projectObject.y+" "+projectObject.z); // projection of a on b
        System.out.println(crossObject.x+" "+crossObject.y+" "+crossObject.z); // cross product
        System.out.println("The status of linear Independence of your vectors is "+linear_ind_obj); // check if 2 vectors are linear independent

    }
}
