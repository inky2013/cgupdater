package uk.co.conclipsegames.projDart.Item;

public enum Resource {
    IRON("Iron"),
    GOLD("Gold"),
    COPPER("Copper"),
    TIN("Tin"),
    SILVER("Silver"),
    LEAD("Lead");

    private String name;

    private Resource(String s)
    {
        name = s;
    }
    public static Resource getFromName(String s)
    {
        for(Resource r : values())
        {
            if(r.name.toLowerCase().equals(s.toLowerCase()))
            {
                return r;
            }
        }

        return null;
    }

    public String getName()
    {
        return name;
    }

}
