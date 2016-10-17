package com.sipgate.type.extension;

import com.sipgate.type.user.MasterSipid;

import java.util.Optional;

public enum ExtensionType
{
	A("a")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new A(masterSipid, extensionId);
		}
	},
	C("c")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new C(masterSipid, extensionId);
		}
	},
	E("e")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new E(masterSipid, extensionId);
		}
	},
	F("f")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new F(masterSipid, extensionId);
		}
	},
	G("g")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new G(masterSipid, extensionId);
		}
	},
	H("h")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new H(masterSipid, extensionId);
		}
	},
	I("i")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new I(masterSipid, extensionId);
		}
	},
	P("p")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new P(masterSipid, extensionId);
		}
	},
	Q("q")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new Q(masterSipid, extensionId);
		}
	},
	R("r")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new R(masterSipid, extensionId);
		}
	},
	S("s")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new S(masterSipid, extensionId);
		}
	},
	T("t")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new T(masterSipid, extensionId);
		}
	},
	V("v")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new V(masterSipid, extensionId);
		}
	},
	W("w")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new W(masterSipid, extensionId);
		}
	},
	X("x")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new X(masterSipid, extensionId);
		}
	},
	Y("y")
	{
		@Override
		public Extension buildExtension(MasterSipid masterSipid, String extensionId)
		{
			return new Y(masterSipid, extensionId);
		}
	};

	private String key;

	private ExtensionType(String key)
	{
		this.key = key;
	}

	abstract Extension buildExtension(MasterSipid masterSipid, String extensionId);

	public String getKey()
	{
		return key;
	}

	public static Optional<ExtensionType> parse(String key)
	{
		for (final ExtensionType type : values())
		{
			if (type.getKey().equalsIgnoreCase(key))
			{
				return Optional.of(type);
			}
		}

		return Optional.empty();
	}
}
