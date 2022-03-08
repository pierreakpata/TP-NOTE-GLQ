package transport;

import java.util.Objects;

public class DoublureColis implements Colis{

    private float prixDetransport;
    private float reduction;
    private float poids;
    private String code;

    public DoublureColis(float poids, String code, float prix, float reduction){
        this.prixDetransport = prix;
        this.reduction = reduction;
        this.poids = poids;
        this.code = code;
    }

    @Override
    public float prixDeTransport() {
        return prixDetransport;
    }

    @Override
    public float reduction() {
        return reduction;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public float poids() {
        return poids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoublureColis that = (DoublureColis) o;
        return Float.compare(that.poids, poids) == 0 && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(poids, code);
    }

    @Override
    public String toString() {
        return "(" +
                "poids=" + poids +
                ", code='" + code + '\'' +
                ')';
    }
}
