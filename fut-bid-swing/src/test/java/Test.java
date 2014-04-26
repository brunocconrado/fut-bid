import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.futbid.domain.Player;
import br.com.futbid.domain.search.Type;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class Test {

    private static ObjectMapper mapper;

    public static void main(String[] args) throws IOException {

	mapper = new ObjectMapper();
	mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
	mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	mapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
	mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

	//String jason = "{'id':2,'idPlayer':146748}";
	//mapper.convertValue(jason, Card.class);

	Classe clazz = new Classe();
	clazz.setType(Type.BALL);

	String json = mapper.writeValueAsString(clazz);

	//JavaType javaType = getJavaType(Classe.class, null);

	Classe b = mapper.readValue(json, Classe.class);
	System.out.println(b.getType());

	List<Player> players = new ArrayList<>();
	Player player = new Player();
	player.setFullName("teste");
	player.setId(44454L);
	players.add(player);

	json = mapper.writeValueAsString(players);

	System.out.println(json);

	List list = mapper.readValue(json,
		TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Player.class));

    }

    protected static JavaType getJavaType(java.lang.reflect.Type type, Class<?> contextClass) {
	return (contextClass != null) ? mapper.getTypeFactory().constructType(type, contextClass) : mapper
		.constructType(type);
    }

    @JsonRootName("classe")
    private static class Classe {
	private Type type;

	public Classe() {
	}

	public Classe(Type type) {
	    this.type = type;
	}

	public Type getType() {
	    return type;
	}

	public void setType(Type type) {
	    this.type = type;
	}

    }

}
