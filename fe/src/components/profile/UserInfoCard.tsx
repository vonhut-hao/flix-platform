import { useState } from "react";
import { Leaf } from "lucide-react";

export function UserInfoCard() {
  const [editing, setEditing] = useState(false);
  return (
    <div className="flex flex-col gap-4">
      <div className="flex items-start gap-4">
        {/* Avatar */}
        <div className="w-24 h-24 rounded-xl overflow-hidden shrink-0 relative">
          <div className="absolute inset-0 bg-gradient-to-br from-[#8fbf8a] to-[#3d7035]" />
          <span className="absolute inset-0 flex items-center justify-center text-white font-['Nimbus_Sans',sans-serif] font-bold text-4xl select-none">
            S
          </span>
        </div>
        <div className="flex flex-col gap-1.5 pt-1">
          <h2 className="text-[#1a1c19] font-['Nimbus_Sans',sans-serif] font-bold text-[22px] leading-tight">
            Shame
          </h2>
          <p className="text-[#6b7280] text-[13px]">shame@example.com</p>
          <span className="inline-flex items-center gap-1 bg-[#f1deb8] text-[#6f6143] text-[11px] px-2.5 py-0.5 rounded-full w-fit tracking-wide">
            <Leaf size={10} />
            GREEN CHAMPION
          </span>
        </div>
      </div>
      <button
        onClick={() => setEditing((e) => !e)}
        className="w-full bg-[#25521f] text-white text-[13px] tracking-widest uppercase py-2.5 rounded-sm hover:bg-[#1e4219] transition-colors"
      >
        {editing ? "SAVE CHANGES" : "Edit Profile"}
      </button>
    </div>
  );
}
