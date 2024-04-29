import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// website for postal apis http://www.postalpincode.in/Api-Details
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostalApiCommunication {
						String	Name;
						String	Description;
						String	BranchType;
						String	DeliveryStatus;
						String	Circle;
						String	District;
						String	Division;
						String	Region;
						String	State;
						String	Country;

}
