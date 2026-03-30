package screenplay.model;

public class GuestCustomer {

    private final String nombre;
    private final String apellido;
    private final String email;
    private final String telefono;
    private final String empresa;
    private final String direccion1;
    private final String ciudad;
    private final String codigoPostal;
    private final String pais;
    private final String region;

    private GuestCustomer(Builder builder) {
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.email = builder.email;
        this.telefono = builder.telefono;
        this.empresa = builder.empresa;
        this.direccion1 = builder.direccion1;
        this.ciudad = builder.ciudad;
        this.codigoPostal = builder.codigoPostal;
        this.pais = builder.pais;
        this.region = builder.region;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public String getEmpresa() { return empresa; }
    public String getDireccion1() { return direccion1; }
    public String getCiudad() { return ciudad; }
    public String getCodigoPostal() { return codigoPostal; }
    public String getPais() { return pais; }
    public String getRegion() { return region; }

    public static class Builder {
        private String nombre;
        private String apellido;
        private String email;
        private String telefono;
        private String empresa = "";
        private String direccion1;
        private String ciudad;
        private String codigoPostal;
        private String pais;
        private String region;

        public Builder nombre(String nombre) { this.nombre = nombre; return this; }
        public Builder apellido(String apellido) { this.apellido = apellido; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder telefono(String telefono) { this.telefono = telefono; return this; }
        public Builder empresa(String empresa) { this.empresa = empresa; return this; }
        public Builder direccion1(String direccion1) { this.direccion1 = direccion1; return this; }
        public Builder ciudad(String ciudad) { this.ciudad = ciudad; return this; }
        public Builder codigoPostal(String codigoPostal){ this.codigoPostal = codigoPostal; return this; }
        public Builder pais(String pais) { this.pais = pais; return this; }
        public Builder region(String region) { this.region = region; return this; }

        public GuestCustomer build() { return new GuestCustomer(this); }
    }

    @Override
    public String toString() {
        return String.format("GuestCustomer{nombre='%s', apellido='%s', email='%s', ciudad='%s'}", nombre, apellido, email, ciudad);
    }
}
