<%@ Page Title="" Language="vb" AutoEventWireup="false" MasterPageFile="~/Site2.Master" CodeBehind="Report1.aspx.vb" Inherits="WebApplication1.WebForm11" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="conMain" runat="server">
     <h2>Report</h2>
    <center>
        <asp:Table Width="90%" ID="Table1" runat="server" GridLines="Both">
            <asp:TableRow runat="server">
                <asp:TableCell CssClass="th1" runat="server">SNo</asp:TableCell>
                <asp:TableCell CssClass="th1" runat="server">Patient Name</asp:TableCell>
                <asp:TableCell CssClass="th1" runat="server">Patient Phone Number</asp:TableCell>
                <asp:TableCell CssClass="th1" runat="server">Pre Score</asp:TableCell>
                <asp:TableCell CssClass="th1" runat="server">Post Score</asp:TableCell>
            </asp:TableRow>

        </asp:Table>
    </center>
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="ContentPlaceHoldelast" runat="server">
</asp:Content>
