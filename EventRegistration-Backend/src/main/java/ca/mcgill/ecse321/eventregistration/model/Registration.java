package ca.mcgill.ecse321.eventregistration.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Registration {
	@EmbeddedId
	private Key key;

	// See
	// https://docs.jboss.org/hibernate/orm/6.5/userguide/html_single/Hibernate_User_Guide.html#identifiers-composite
	// for the rules on composite IDs.
	@Embeddable
	public static class Key implements Serializable {
		@ManyToOne
		private Person registrant;
		@ManyToOne
		private Event event;

		public Key() {
			super();
		}

		public Person getRegistrant() {
			return registrant;
		}

		public Event getEvent() {
			return event;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Key)) {
				return false;
			}
			Key that = (Key) obj;
			return this.getRegistrant().getId() == that.getRegistrant().getId()
					&& this.getEvent().getId() == that.getEvent().getId();
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.getRegistrant().getId(), this.getEvent().getId());
		}
	}
}
